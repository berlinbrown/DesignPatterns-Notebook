/**
 * Copyright (c) 2006-2010 Berlin Brown (berlin dot brown @gmail.com) All Rights Reserved
 *
 * http://www.opensource.org/licenses/bsd-license.php
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer. *
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution. * Neither the name of the Botnode.com (Berlin Brown) nor the names
 * of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * 4/4/2012 bbrown Contact: Berlin Brown <berlin dot brown at gmail.com>
 */
package org.berlin.patterns.swing.app.io;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a standard Java class.
 *
 * @author berlin
 */
public class NewLogDownloadFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewLogDownloadFile.class);
    
    public void download(final File fileProcess, final boolean isUnzipArchiveFiles, final String getLocalTargetDir, final ServerDirConf dir) {
        final long tstart2 = System.currentTimeMillis();
        try {        
            final FileWriterConf conf = new FileWriterConf();
            final String jvmMangleName = new CustomFilenameMangler(conf, dir).parseJvmMangle();
            final String localFileName = fileProcess.getName() + "." + dir.server + "." + jvmMangleName;
            final String fileStrLocalTarget = getLocalTargetDir + "\\" + localFileName;            
            // Add a bug fix to allow for c$ file names, etc
            final String improperLocalFilename = fileStrLocalTarget.replaceAll("\\\\[a-z]\\$", "_localDrive_");
            final File localTargetFile = new File(improperLocalFilename);
            LOGGER.info("<mId-DL@2.90> -> Writing to {LOCAL} file : " + localTargetFile + " //dir.server="+dir.server);
            final LogFileWriter writer = new LogFileWriter(fileProcess, localTargetFile);
            boolean res = writer.copy();
            final boolean isZipFile = fileProcess.getName().indexOf(".Z") != -1;
            // If file type is archived, also do a unzip
            if (isUnzipArchiveFiles && res && isZipFile) {
                LOGGER.info("<mId-DL@2.90> -> Attempting uncompress using Z file uncompress");
                final UnixUncompressWriter unzip = new UnixUncompressWriter(localTargetFile.getAbsolutePath(), conf, dir);
                unzip.unzipWrite();
                unzip.deleteArchiveFile();
            } else {
                if (!isUnzipArchiveFiles && res && isZipFile) {
                    LOGGER.info("<mId-DL@2.90>WARN - attempt to delete archive file while unzip is false (may not want to delete)");
                    final File fx = new File(localTargetFile.getAbsolutePath());
                    fx.delete();
                } // End of the if - else //
            } // End of the if - else //
            final long tdiff = System.currentTimeMillis() - tstart2;
            LOGGER.info("<mId-DL@2.90> -> Done in procTime=" + tdiff + " ms");
        } catch (Exception nfe) {
            nfe.printStackTrace();
            LOGGER.error("<mId-DL@2.90> Error at download", nfe);
        } // End of the try - catch //
    } // End of the method //
} // End of the class //

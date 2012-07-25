/**
 * Copyright (c) 2006-2010 Berlin Brown. All Rights Reserved
 * 
 * http://www.opensource.org/licenses/bsd-license.php
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. * Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. * Neither the name of the Botnode.com (Berlin Brown)
 * nor the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * **********************************************
 * File : 
 * 
 * Date: 7/20/2012 
 * 
 * bbrown Contact: Berlin Brown
 * <berlin dot brown at gmail.com>
 * 
 * keywords: design patterns
 * 
 * Based on design patterns book:
 * 
 * Design Patterns - Elements of Reusable Object-Oriented Software
 * by:
 *   Erich Gamma
 *   Richard Helm
 *   Ralph Johnson
 *   John Vlissides
 *   
 * Addison-Wesley 1995
 * 
 * URLs:
 * 
 * https://github.com/berlinbrown   
 * **********************************************
 */
package org.berlin.patterns.creational.builder;

/**
 * Implementation builds simple mazes.  Build the structure internally.
 * 
 */
public class StandardMazeBuilder implements IMazeBuilder {

	private IMaze currentMaze = null;
	
	public StandardMazeBuilder(final IMaze maze) {
		this.currentMaze = maze;
	}
	
	@Override
    public void buildMaze() {
		this.currentMaze = new BasicMaze();	    
    }

	/**
	 * Create a room and build walls.
	 */
	@Override
    public void buildRoom(int room) {
		final IRoom internalRoom = new Room();
		this.currentMaze.addRoom(internalRoom);
		
		// Add walls to the room //
		internalRoom.setSide(0, new Wall());
		internalRoom.setSide(1, new Wall());
		internalRoom.setSide(2, new Wall());
		internalRoom.setSide(3, new Wall());
    }
		
	/**
	 * Build up the door.
	 */
	@Override
    public void buildDoor(int roomFrom, int roomTo) {	
	    final IRoom room1 = this.currentMaze.getRoomByNum(roomFrom);
	    final IRoom room2 = this.currentMaze.getRoomByNum(roomTo);
	    final IWall commonWall = new Wall();
	    room1.setSide(0, commonWall);
	    room2.setSide(1, commonWall);
    }

	@Override
    public IMaze getMaze() {
	    return this.currentMaze;
    }
	
} // End of the class //

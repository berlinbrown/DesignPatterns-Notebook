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
package org.berlin.patterns.behavioral.interpreter;

/**
 * Behavioral Pattern, dealing with algorithm operations. 
 */


public class AndExp implements IBooleanExp {

	private final IBooleanExp op1;
	private final IBooleanExp op2;
		
	public AndExp(final IBooleanExp op1, final IBooleanExp op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
	
	@Override
    public Object evaluate(Context context) {	 
	    return (Boolean)this.op1.evaluate(context) && (Boolean)this.op2.evaluate(context); 
    }

}

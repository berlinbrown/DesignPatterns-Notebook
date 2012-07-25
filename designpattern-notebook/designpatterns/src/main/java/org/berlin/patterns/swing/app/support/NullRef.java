package org.berlin.patterns.swing.app.support;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Utility class to work with null references.
 * 
 * @author berlin
 * @version $Revision: 1.0 $
 */
public class NullRef<T> implements Serializable {

    /**
     * Serial version id.
     */
    private static final long serialVersionUID = 1L;
 
    /**
     * Utility to check if string is empty.
     * 
     * @param str
     * @return boolean
     */
    public static boolean isEmptyTrim(final String str) {
        return (str == null) || (str.trim().length() == 0);
    }

    /**
     * Simple utility to check if string is empty.
     * 
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(final String str) {
        return (str == null) || (str.length() == 0);
    }
    
    /**
     * Method hasValue.
     * @param testObj Object
     * @return boolean
     */
    public static boolean hasValue(final Object testObj) {
        boolean rc = false;
        if (null != testObj) {
            rc = true;
        }
        return rc;
    }

    /**
     * Check if string has value, also check for str.trim is empty.
     * @param testString
     * @return boolean
     */
    public static boolean hasValue(final String testString) {
        return !isEmptyTrim(testString);
    }    

    /**
     * Return true if does not have value.
     * 
     * @param testObj Object
     * @return boolean
     */
    public static boolean nil(final Object testObj) {
        return !hasValue(testObj);
    }

    /**
     * Check if string has value, also check for str.trim is empty.
     * Return true if null or empty.
     * 
     * @param testString
     * @return boolean
     */
    public static boolean nil(final String testString) {
        return !hasValue(testString);
    }
    
    /**
     * Method get.
     * @param inVal Short
     * @return Short
     */
    public Short get(final Short inVal) {
        return (inVal == null) ? 0 : inVal;        
    }
    /**
     * Method get.
     * @param inVal Long
     * @return Long
     */
    public Long get(final Long inVal) {
        return (inVal == null) ? 0 : inVal;        
    }
    /**
     * Method get.
     * @param inVal Double
     * @return Double
     */
    public Double get(final Double inVal) {
        return (inVal == null) ? 0.0d : inVal;        
    }
    /**
     * Method get.
     * @param inVal Float
     * @return Float
     */
    public Float get(final Float inVal) {
        return (inVal == null) ? 0.0f : inVal;        
    }
    /**
     * Method get.
     * @param inVal Integer
     * @return Integer
     */
    public Integer get(final Integer inVal) {
        return (inVal == null) ? 0 : inVal;        
    }
    /**
     * Method get.
     * @param inVal Integer
     * @return Integer
     */
    public Boolean get(final Boolean inVal) {
        return (inVal == null) ? false : inVal;        
    }    
    
    /**
     * Attempt to get object, if null create instance
     * with default constructor.
     * 
     * @param inVal T
     * @return T
     */
    public T get(final T inVal) {
        if (inVal == null) {
            try {
                return getTypeParameterClass().newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();                
            }            
        }
        return inVal;
    }    
    
    /**
     * Attempt to get object, if null create instance
     * with default constructor.
     * 
     * 'When' object reference is null, create instance of type or return input parameter.  
     * 
     * @param inVal T
     * @return T
     */
    public T when(final T inVal) {
        return get(inVal);
    }
    /**
     * Attempt to get object, if null create instance
     * with default constructor.
     * 
     * 'When' object reference is null, create instance of type or return input parameter.  
     * 
     * @param inVal T
     * @return T
     */
    public T ifNull(final T inVal) {
        return get(inVal);
    }
    /**
     * Attempt to get object, if null create instance
     * with default constructor.
     * 
     * 'When' object reference is null, create instance of type or return input parameter.  
     * 
     * @param inVal T
     * @return T
     */
    public T notNull(final T inVal) {
        return get(inVal);
    }
    
    /**
     * Same as get but force call to handle exceptions.
     * 
     * @param inVal
     * @return T
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public T getUnsafe(final T inVal) throws IllegalAccessException, InstantiationException {
        return getTypeParameterClass().newInstance();                               
    }
            
    /**
     * Method getTypeParameterClass.
     * @return Class<T>
     */
    @SuppressWarnings ("unchecked")
    public Class<T> getTypeParameterClass() {    
        final Type type = getClass().getGenericSuperclass();
        final ParameterizedType paramType = (ParameterizedType) type;
        return (Class<T>) paramType.getActualTypeArguments()[0];
    }    
} // End of the class //
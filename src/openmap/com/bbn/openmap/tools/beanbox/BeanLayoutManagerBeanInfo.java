/* **********************************************************************
 * 
 *    Use, duplication, or disclosure by the Government is subject to
 *           restricted rights as set forth in the DFARS.
 *  
 *                         BBNT Solutions LLC
 *                             A Part of 
 *                  Verizon      
 *                          10 Moulton Street
 *                         Cambridge, MA 02138
 *                          (617) 873-3000
 *
 *    Copyright (C) 2002 by BBNT Solutions, LLC
 *                 All Rights Reserved.
 * ********************************************************************** */

package com.bbn.openmap.tools.beanbox;

import java.beans.*;
import java.util.List;
import java.util.ArrayList;

/**
 * BeanInfo for a {@link com.bbn.openmap.tools.beanbox.BeanLayoutManager}.
 */
public class BeanLayoutManagerBeanInfo extends SimpleBeanInfo {
  
  /**
   * returns the location of the 16 x 16 bit image icon. 
   */
  public String getImage16Location() {
    return
      "BeanLayoutManagerIcon16.gif";
      }

  /**
   * returns the location of the 32 x 32 bit image icon. 
   */
  public String getImage32Location() {
    return 
      "BeanLayoutManagerIcon32.gif";
  }

  /**
   * subclasses should NOT
   * over-ride this method. Instead, they should over-ride
   * localProperties to create their own properties.
   */
  public PropertyDescriptor[] getPropertyDescriptors() {
    ArrayList list = new ArrayList(10);
    localProperties(list);
    return (PropertyDescriptor[])list.toArray(new PropertyDescriptor [0]);
  }
  
  /**
   * direct and indirect subclasses of this bean info class should 
   * override this method to add their property descripters to the list
   * generated by the super-class method. A localProperties method 
   * written in the subclass should include in a call to 
   * super.localProperties in order to get the list of superclass
   * property descripters. It should then add its own property descriptors
   * to this list. A subclass does not need to over-ride this method
   * if it has no property descripters of its own to add to the list
   * of super-class descriptors.
   * @param ps a List containing property descripters of all super
   * classes.
   */
  protected void localProperties (List ps) {
  }


  /**
   * returns the image associated with the bean.
   * This method calls getImage16Location() and getImage32Location() to locate
   * the image file.
   * @return An image object containing a 16 x 16 bit image is returned if found
   * otherwise a 32 x 32 bit image is returned if found. Else a null is returned.
   */
  public java.awt.Image getIcon(int iconKind) {
    if (iconKind == BeanInfo.ICON_COLOR_16x16 || 
        iconKind == BeanInfo.ICON_MONO_16x16) {
      java.awt.Image img = loadImage(getImage16Location());
      return img;
    } else
      if (iconKind == BeanInfo.ICON_COLOR_32x32 ||
          iconKind == BeanInfo.ICON_MONO_32x32) {
        java.awt.Image img = loadImage(getImage32Location());
        return img;
      }
    return null;
  }

  /**
   * A convenience method to create and add a property descriptor
   * to a list. A subclass of this bean info class can use this
   * method to add its own property descriptors to the list of 
   * super class property descriptors made available in the 
   * localProperties method.
   * @param ps list of property descriptors
   * @param name the name of the property
   * @param beanClass the Bean class defining the property
   */
  protected static void property(List ps,
                                 String name, 
                                 Class beanClass) {
      property(ps,name, beanClass, null);
  }

  /**
   * A convenience method to create and add a property descriptor
   * to a list and associate an editor class with the property.
   * A subclass of this bean info class can use this method
   * to add its own property descriptors to the list of 
   * super class property descriptors made available in the 
   * localProperties method.
   * @param ps list of property descriptors
   * @param name the name of the property
   * @param beanClass the Bean class defining the property
   * @param editorClass a class to be registered as the editor for the
   * specified property.
   */
  protected static void property(List ps,
                                 String name, 
                                 Class beanClass, Class editorClass) {
    try {
       PropertyDescriptor pd = new PropertyDescriptor(name, beanClass);
      if (editorClass != null)
        pd.setPropertyEditorClass(editorClass);
      ps.add(pd);
    } catch (Exception e)  {}
  }
}

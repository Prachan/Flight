package com.fb.util;



import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.fb.constants.ErrorConstants;



public class PropertyUtility {
private static final Logger LOG=Logger.getLogger(PropertyUtility.class);
private static ResourceBundle getBundles(final String filename) {
final Locale currentLocale = Locale.getDefault();
LOG.info("PropertyUtility Class getBuddles called");
return ResourceBundle.getBundle(filename, currentLocale);

}
public static String getErrorMessage(final String key) {
LOG.info("Error for code "+key);
final ResourceBundle messages = getBundles(ErrorConstants.ERRORMESSAGES);
return messages.getString(key);
}
}
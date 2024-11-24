package com.neptune.cbawrapper.Exception;


/**
 * A {@link RuntimeException} thrown when a valid API request ends up violating
 * some domain rule.
 */
public class AbstractPlatformDomainRuleException extends AbstractPlatformException {
    protected AbstractPlatformDomainRuleException(String globalisationMessageCode, String defaultUserMessage,
                                                  Object... defaultUserMessageArgs) {
        super(globalisationMessageCode, defaultUserMessage, defaultUserMessageArgs);
    }
}

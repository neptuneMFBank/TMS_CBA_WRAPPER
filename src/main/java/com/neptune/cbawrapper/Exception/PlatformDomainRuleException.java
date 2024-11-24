package com.neptune.cbawrapper.Exception;


public class PlatformDomainRuleException extends AbstractPlatformDomainRuleException {
    public PlatformDomainRuleException(String globalisationMessageCode, String defaultUserMessage,
                                       Object... defaultUserMessageArgs) {
        super(globalisationMessageCode, defaultUserMessage, defaultUserMessageArgs);
    }
}

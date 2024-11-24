package com.neptune.cbawrapper.Exception;

/**
 * A {@link RuntimeException} thrown when fund resources are not found.
 */
public class AuthenticationException extends AbstractPlatformDomainRuleException {
    public AuthenticationException(final String msg) {
        super("error.msg.authentication.invalid", msg);
    }

    public AuthenticationException(final String msg, final String err) {
        super("error.msg.authentication.invalid", msg, err);
    }
}

package com.atscale.keycloak.broker.oidc.mappers;

import java.util.ArrayList;
import java.util.List;

import org.keycloak.broker.oidc.KeycloakOIDCIdentityProviderFactory;
import org.keycloak.broker.oidc.OIDCIdentityProviderFactory;
import org.keycloak.broker.oidc.mappers.AbstractClaimMapper;
import org.keycloak.provider.ProviderConfigProperty;

public class AtScaleExceptionOnMissingClaim extends AbstractClaimMapper {

    public static final String PROVIDER_ID = "atscale-exception-on-missing-claim-mapper";

    private static final List<ProviderConfigProperty> configProperties = new ArrayList<ProviderConfigProperty>();

    public static final String CLAIM_PROPERTY_NAME = "claims";
    public static final String ARE_CLAIM_VALUES_REGEX_PROPERTY_NAME = "are.claim.values.regex";
    public static final String EXCEPTION_MESSAGE_PROPERTY_NAME = "exception.message";


    static {
        ProviderConfigProperty claimsProperty = new ProviderConfigProperty();
        claimsProperty.setName(CLAIM_PROPERTY_NAME);
        claimsProperty.setLabel("Claims");
        claimsProperty.setHelpText("Name and value of the claims to search for in token. You can reference nested claims using a '.', i.e. 'address.locality'. To use dot (.) literally, escape it with backslash (\\.)");
        claimsProperty.setType(ProviderConfigProperty.MAP_TYPE);
        configProperties.add(claimsProperty);
        ProviderConfigProperty isClaimValueRegexProperty = new ProviderConfigProperty();
        isClaimValueRegexProperty.setName(ARE_CLAIM_VALUES_REGEX_PROPERTY_NAME);
        isClaimValueRegexProperty.setLabel("Regex Claim Values");
        isClaimValueRegexProperty.setHelpText("If enabled claim values are interpreted as regular expressions.");
        isClaimValueRegexProperty.setType(ProviderConfigProperty.BOOLEAN_TYPE);
        configProperties.add(isClaimValueRegexProperty);
        ProviderConfigProperty exceptionMessageProperty = new ProviderConfigProperty();
        exceptionMessageProperty.setName(EXCEPTION_MESSAGE_PROPERTY_NAME);
        exceptionMessageProperty.setLabel("Exception Message");
        exceptionMessageProperty.setHelpText("Message to include in the exception if claim is missing.");
        exceptionMessageProperty.setType(ProviderConfigProperty.STRING_TYPE);
        configProperties.add(exceptionMessageProperty);
    }


    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public String getDisplayType() {
        return "AtScale Exception on Missing Claim Mapper";
    }

    @Override
    public String getHelpText() {
        return "This mapper throws an exception if a required claim is missing in the token.";
    }

    @Override
    public String[] getCompatibleProviders() {
        return new String[]{KeycloakOIDCIdentityProviderFactory.PROVIDER_ID, OIDCIdentityProviderFactory.PROVIDER_ID};
    
}

    @Override
    public String getDisplayCategory() {
        return "Exception on Missing Claim";
    }

  @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return configProperties;
    }
}
package com.dtupay.BusinessLogic;

import com.dtupay.app.Token;
import com.dtupay.database.exceptions.CustomerHasNoUnusedToken;
import com.dtupay.database.exceptions.FakeToken;
import com.dtupay.database.exceptions.TokenAlreadyUsed;

import java.util.List;
import java.util.UUID;

public interface IBusinessLogicForToken {
    // GET /token/unused/{customer_id}
    // DONE
    Token getUnusedTokenByCustomerId(int customerId) throws CustomerHasNoUnusedToken;

    // POST /token
    // DONE
    Token createToken(int customerId, UUID uuid, boolean used);

    // get /token/validation/id
    boolean isTokenValid(int tokenId);

    // PUT /token/{id}
    // DONE
    void markTokenAsUsed(int tokenId) throws FakeToken, TokenAlreadyUsed;

    // GET /token
    // DONE
    List<Token> getAllTokens();

}

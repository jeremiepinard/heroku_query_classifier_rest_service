package com.radialpoint.exceptionMappers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by jeremies on 18/09/14.
 */
@Provider
public class JsonParseExceptionExceptionMapper implements ExceptionMapper<JsonParseException>
{

    @Override
    public Response toResponse(JsonParseException exception)
    {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("The provided json is invalid.")
                .type( MediaType.TEXT_PLAIN)
                .build();
    }

}
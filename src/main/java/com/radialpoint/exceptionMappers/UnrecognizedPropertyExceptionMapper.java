package com.radialpoint.exceptionMappers;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnrecognizedPropertyExceptionMapper implements ExceptionMapper<UnrecognizedPropertyException>
{

    @Override
    public Response toResponse(UnrecognizedPropertyException exception)
    {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity( "'" + exception.getUnrecognizedPropertyName() + "' is an unrecognized field.")
                .type( MediaType.TEXT_PLAIN)
                .build();
    }

}
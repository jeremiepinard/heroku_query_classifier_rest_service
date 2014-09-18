package com.radialpoint.services.rest;

import java.io.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.radialpoint.queryclassifier.classifier.Classifier;
import com.radialpoint.utils.PersonalQueryClassifierUtil;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/isPersonal")
public class QueryClassifier {

    public static class Input{

        public Input() {}

        public String getQuery() {
            return query;
        }

        @JsonProperty
        private String query;
    }

    public static class Output{

        public Output(Double confidence) {
            isPersonalConfidence = confidence;
        }

        @JsonProperty
        private Double isPersonalConfidence;
    }

    private static final Logger LOG = LoggerFactory.getLogger(QueryClassifier.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Output isQueryPersonal(Input query) throws Exception {
        Double isPersonalConfidence = PersonalQueryClassifierUtil.classify(query.getQuery());
        LOG.info(String.format("Classifying the query [%s] as personal with confidence of [%s]", query.getQuery(), isPersonalConfidence));
        return new Output(isPersonalConfidence);
    }
}

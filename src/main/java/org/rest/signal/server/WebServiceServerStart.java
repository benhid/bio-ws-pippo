package org.rest.signal.server;

import ro.pippo.core.Pippo;

public class WebServiceServerStart {

    public static void main(String[] args) {
        Pippo pippo = new Pippo(new WebServiceServer());
        pippo.addFileResourceRoute("/static/", "src/main/resources/static/");
        pippo.start();
    }

}
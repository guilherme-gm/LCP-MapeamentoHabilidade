/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.habilidades.commands;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author guilh
 */
public class CommandResult {

    private final boolean redirect;
    private final String page;
    private final Map<String, Object> attributes;

    public CommandResult(String page) {
        this.page = page;
        this.redirect = false;
        this.attributes = null;
    }

    public CommandResult(HttpServletRequest request, String page) {
        this.page = page;

        Enumeration<String> attr = request.getAttributeNames();
        this.attributes = new HashMap();

        while (attr.hasMoreElements()) {
            String attributeName = attr.nextElement();
            this.attributes.put(attributeName, request.getAttribute(attributeName));
        }

        this.redirect = true;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public String getPage() {
        return page;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

}

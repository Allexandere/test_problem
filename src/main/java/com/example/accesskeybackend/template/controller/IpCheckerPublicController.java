package com.example.accesskeybackend.template.controller;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.http.conn.util.InetAddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.URL;

@RestController
@RequestMapping("/api/web")
@AllArgsConstructor
public class IpCheckerPublicController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/checkIpv6Support")
    @SneakyThrows
    public boolean checkIpv6Support(
            @Parameter(description = "URL")
            @RequestParam(name = "siteUrl") String siteUrl
    ) {
        InetAddress[] addresses = InetAddress.getAllByName(siteUrl);
        for (InetAddress address : addresses) {
            if (InetAddressUtils.isIPv6Address(address.getHostAddress())) {
                return true;
            }
        }
        return true;
    }
}

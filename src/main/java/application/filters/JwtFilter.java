package application.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.SignatureException;

/**
 * Created by hamish on 14/05/17.
 */
public class JwtFilter extends GenericFilterBean {

    @Override
    @CrossOrigin
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new ServletException("Missing or invalid Authorization header.");
        }

        final String token = authHeader.substring(7); // The part after "Bearer "

        try {
            final Claims claims = Jwts.parser().setSigningKey("SECRET_KEY_NEEDS_UPDATING_EH_BRO")
                    .parseClaimsJws(token).getBody();
            request.setAttribute("claims", claims);
        }
        catch (Exception e) {
            throw new ServletException("Invalid token.");
        }

        chain.doFilter(req, res);
    }

}
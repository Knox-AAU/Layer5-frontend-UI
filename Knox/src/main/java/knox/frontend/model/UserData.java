package knox.frontend.model;

import knox.frontend.security.SecurityConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UserData {
    private String title;
    private String username;
    private List<HubIcon> AccessibleDatabases;

    public UserData () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        this.username = authentication.getName();
        this.AccessibleDatabases = new ArrayList<HubIcon>();
        Collection<GrantedAuthority> credentials = (Collection<GrantedAuthority>)  authentication.getAuthorities();
        SetAccessibleDatabases(credentials);
    }

    private void SetAccessibleDatabases (Collection<GrantedAuthority> credentials){
        Iterator<GrantedAuthority> iterator = credentials.iterator();
        while (iterator.hasNext()){
            GrantedAuthority role = iterator.next();
            final String postfix = "ROLE_";
            switch (role.getAuthority()){
                case postfix + SecurityConfiguration.ROLES.ADMIN : {
                    break;
                }
                case postfix + SecurityConfiguration.ROLES.GRUNDFOS : {
                    this.AccessibleDatabases.add(HubIcon.CreateGrundfosIcon());
                    break;
                }
                case postfix + SecurityConfiguration.ROLES.NORDJYSKE : {
                    this.AccessibleDatabases.add(HubIcon.CreateNordJyskeIcon());
                    break;
                }
            }
        }
    }


    public List<HubIcon> getAccessibleDatabases() {
        return AccessibleDatabases;
    }

    public void setAccessibleDatabases(List<HubIcon> accessibleDatabases) {
        AccessibleDatabases = accessibleDatabases;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static UserData CreateKnoxHeader () {
        UserData userData = new UserData();
        userData.title = "Knox Hub";
        return userData;
    }
    public static UserData CreateGrundfosHeader () {
        UserData userData = new UserData();
        userData.title = "Knox: Grundfos";
        return userData;
    }
}

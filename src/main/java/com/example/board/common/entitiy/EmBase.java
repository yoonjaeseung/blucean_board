package com.example.board.common.entitiy;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Slf4j
@MappedSuperclass
@Setter
@Getter
public class EmBase implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createDatetime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createDatetime;

    @Column(name = "createHost", length = 40)
    private String createHost;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updateDatetime")
    private Date updateDatetime;

    @Column(name = "updateHost", length = 40)
    private String updateHost;

    @Transient
    private boolean isChangeHost = false;

    @PrePersist
    public void prePersist() {
        if (StringUtils.isEmpty(createHost)) createHost = getHost(this.createHost);
        if (StringUtils.isEmpty(updateHost)) updateHost = getHost(this.updateHost);
        if (createDatetime == null) createDatetime = new Date();
        if (updateDatetime == null) updateDatetime = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        if (StringUtils.isEmpty(updateHost)) updateHost = getHost(this.updateHost);
        if (updateDatetime == null) updateDatetime = new Date();
    }

    public String getCreateHost() {
        if (!StringUtils.isEmpty(this.createHost) && this.createHost.startsWith("admin-")) {
            return this.createHost.replace("admin-", "");
        }
        return this.createHost;
    }

    public String getUpdateHost() {
        if (!StringUtils.isEmpty(this.updateHost) && this.updateHost.startsWith("admin-")) {
            return this.updateHost.replace("admin-", "");
        }
        return this.updateHost;
    }

    private String getHost() {
        String hostName = "";
        try {
            hostName = java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            log.error(e.toString(), e);
        }
        return hostName;
    }

    private String getHost(String hostName) {
        if (!StringUtils.isEmpty(hostName) && hostName.startsWith("admin-"))
            return hostName;
        String newHostName = getHost();
        if (hostName == null || hostName.equals("") || !newHostName.equals(hostName))
            return newHostName;
        return hostName;
    }

    public void changeHostName(String hostName, boolean includeCreateHost) {
        if (includeCreateHost) this.createHost = hostName;
        this.updateHost = hostName;
        this.isChangeHost = true;
    }

}
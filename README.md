# Email verification API

![Screenshot](https://i.postimg.cc/NFst1m6S/Screenshot.png)

# What is this?

A **complete, secure, ready to use, highly customizable** email verifier API.

# How to use

### Clone the project

    git clone https://github.com/amir-shiati/email-verification-api.git

### [Edit the configuration file](#Edit the configuration file)

    vi email-verification-api/src/main/resources/application.yml

### Done! Run the project...

    mvn spring-boot:run

# Edit the configuration file

open up **application.yml** file (located inside email-verification-api/src/main/resources/) and set the required
information.

### set your smtp server information:

```yaml
smtp:
  # your smtp server host
  host: smtp.your-domain.com
  # your smtp server port
  port: 587
  # your smtp server username
  username: your-smtp-username
  # your smtp server password
  password: your-smtp-password
```

### set your database information:

```yaml
datasource:
  # database url
  jdbc-url: jdbc:postgresql://localhost:5432/your-database-name
  # database username
  username: your-database-username
  # database password
  password: your-database-password
```

### change jwt user information:

```yaml
security:
  jwt:
    # jwt username (used to get jwt authentication token)
    username: changeme
    # jwt password (used to get jwt authentication token)
    password: changeme
```


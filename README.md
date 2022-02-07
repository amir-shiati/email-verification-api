# Email verification API

![Screenshot](https://i.postimg.cc/NFst1m6S/Screenshot.png)

# What is this?

A **Fast, Secure, Ready to use, Highly customizable** email verifier API.

# How to use

### Clone the project

    git clone https://github.com/amir-shiati/email-verification-api.git

### [Edit the configuration file](#Edit-the-configuration-file)

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

## All set!

# Customizing

**You can customize both the code and the html content of the email.**

### Customizing html content of the email:

open up **application.yml** file (located inside email-verification-api/src/main/resources/).

Inside the **html** section change these variables:

```yaml
html:
  template:
    # path to the html template
    path: src/main/resources/templates/
    # name of the html template file
    file-name: template
    # name of the variable used for code inside the html template
    variable-name: code
```

- **Template file is a html file but because of the templating engine used it must end with a chtml extension!**
- **Indicate where you would want to put the generated code inside the html file using the {$code} tag.**

### Customizing the code

Inside the **code** section change these variables:

```yaml
code:
  # the length of the code
  length: 6
  # should it contain digits?
  digits: true
  # should it contain uppercase letters?
  upper: false
  # should it contain lowercase letters?
  lower: false
  # How long should the code be valid?
  valid-for-minutes: 5
```

# Security

**All the endpoints have been secured using jwt.**

# Endpoints
[Here is the documentation ](https://github.com/amir-shiati/email-verification-api/blob/main/doc.md)

# TODO
- [ ] Add post configuration
- [ ] Add a queue
- [ ] Add support for bulk validation
- [ ] Dockerize the project




# BornIn

BornIn is a basic SpringBoot application that stores and manages user's date of birth information. 

### What you will need?
#### Build&Run
* JDK 17 or later
* Gradle 7.3+
* Google account
* IDE

### Quickstart
#### Local Build & Testing
###### Clone project
`git clone https://github.com/exosolarplanet/BornIn.git`

###### Export environment variables
* `export db_name=<database-name>`
* `export db_user=<database-username>`
* `export db_pass=<database-password>`
* `export db_ip=<database-ip-address>`


### Endpoints
| Endpoint | Description | Request Type | Return Code | Return Body |
| --- | --- | --- | --- | --- |
| `/health` | check for application health | GET | 200 | "Healthy"
| `/hello/{username}` | save date of birth information for username | PUT | 204 | n/a |
| `/hello/{username}` | save date of birth information for username | GET | 200 | "{ "message": "Hello, %s! Your birthday is in %d day(s)" }" |


# openziti-example
an zero trust project with openziti example


## Example Setup

This example will use a tunneler as the client along with a SpringBoot enabled server.

* download ziti CLI (or use the ZAC but this readme uses ziti CLI) and make sure it's on the path
* be in this folder
* make a folder for identities: `mkdir identities`
* create the server identity: `ziti edge create identity example-server -o ./identities/example-server.jwt`
* enroll server identity: `ziti edge enroll .\identities\example-server.jwt`
* create an intercept config: `ziti edge create config example-server-intercept intercept.v1 '{\"protocols\":[\"tcp\"],\"addresses\":[\"spring.boot\"], \"portRanges\":[{\"low\":80, \"high\":80}]}'`
* create the service: `ziti edge create service example-server-svc --configs 'example-server-intercept'`
* create a client identity: `ziti edge create identity example-client -o ./identities/example-client.jwt`
* authorize the server to bind the service: `ziti edge create service-policy example-bind Bind --identity-roles '@example-server' --service-roles '@example-server-svc'`
* authorize the client to dial the service: `ziti edge create service-policy example-dial Dial --identity-roles '@example-client' --service-roles '@example-server-svc'`


## Running the Example
change to the example project:
* `cd example`

Package the server:
* `mvn clean package`

Start the server:
* `java -jar target\example-1.0-SNAPSHOT.jar`

Use curl to verify things are working:
```
PS> curl http://spring.boot/helloZiti
Hello OpenZiti
```

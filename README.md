## For what?

Client to check the status of remote nodes of the OPEN Platform project


#### Running

To build and run the application, you will need Java and Docker preinstalled.

```bash
$ git clone https://github.com/pavel-evleev/openchain_supervizer.git
$ cd openchain_supervizer
$ ./gradlew build
$ docker build -t open-supervizer .
$ docker run -p 8080:8900 open-supervizer
```

## RPC API


|URL|METHOD|DESCRIPTION|
|------------------------|:----:|----------------------|
|`/nodes/remote/status`|GET|Get remote nodes common information |
|`/nodes/local/status`|GET|Get <i>localhost</i> nodes common information |
|`/nodes/remote/delegates`|GET|Get remote nodes info about delegates|
|`/nodes/remote/delegates/active`|GET|Get remote nodes info about active delegates|

Local web server

The server is designed to deliver content to the client.
The server runs on port number 80 (http-default) !!!

Install:

1. Place the files com.web.srv.local-web-server.list and com.web.srv.local-web-server.cfg in {smx_dir}/etc/
2. Install, if not installed feature in smx camel-jaxb, camel-jetty
3. Put the file jar in the folder {smx_dir}/deploy/
4. Change the start-level to 60

Configuring the server:
local-web-server.port = [port number]

[port number] - port number to which the listener is installed *

Configuring content mapping (com.web.srv.local-web-server.list):
```

<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<listEqualsFilesHolder>
    <listEqualsFiles>
        <entry>
            <key>[url request]</key>
            <value>[file path]</value>
        </entry>
    </listEqualsFiles>
</listEqualsFilesHolder>
```

listEqualsFiles - a map that stores the mapping of queries and files

[url request] - customer request

[file path] - the file to be given to the client

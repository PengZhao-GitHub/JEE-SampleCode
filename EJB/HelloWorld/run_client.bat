cd classes
java -Djava.security.policy=../java.policy -Djava.naming.factory.initial=weblogic.jndi.WLInitialContextFactory -Djava.naming.provider.url=t3://localhost:7001 examples.HelloClient
cd ..

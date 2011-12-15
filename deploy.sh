ant

if [ $? -ne 0 ]
then
	echo -n "aborting deployment at "
	date
	exit 1;
fi

rm /var/lib/tomcat6/webapps/betterweather.war > /dev/null 2>&1
rm -r /var/lib/tomcat6/webapps/betterweather > /dev/null 2>&1

if [ $? -ne 0 ]
then
	echo "the old servlets werent there...proceeding as planned"
else
	echo "old servlets removed"
fi

cp /home/j/betterweather/dist/betterweather.war /var/lib/tomcat6/webapps/betterweather.war 2>&1

if [ $? -ne 0 ]
then
	echo "new servlet is nowhere to be found"
	echo -n "aborting deployment at "
	date
	exit 1;
fi
echo "new servlet copied"

/etc/init.d/tomcat6 restart

echo -n "betterweather deployed at "
date

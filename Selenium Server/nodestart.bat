java -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5556 -browser "browserName=iexplore-browser, maxInstances=1" -browser "browserName=firefox, maxInstances=4" -browser "browserName=chrome, maxInstances=3, version=79" -browser "browserName=MicrosoftEdge, maxInstances=1" -browser "browserName=operablink, maxInstances=3"

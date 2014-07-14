gnome-terminal -e "bash -c \"cd TrafficIncidentsService;./RunTrafficIncidentsService.sh;exec bash\""

sleep 1
gnome-terminal -e "bash -c \"cd TrafficIncidentsFeed;./RunTrafficIncidentsFeed.sh;exec bash\""

sleep 1
gnome-terminal -e "bash -c \"cd TrafficIncidentsConfiguration;./RunTrafficIncidentsConfiguration.sh;exec bash\""

sleep 1
gnome-terminal -e "bash -c \"cd TrafficIncidentsListClient;./RunTrafficIncidentsListClient.sh;exec bash\""

sleep 1
gnome-terminal -e "bash -c \"cd TrafficIncidentsMapClient;./RunTrafficIncidentsMapClient.sh;exec bash\""

sleep 1
gnome-terminal -e "bash -c \"cd TrafficIncidentsWarningClient;./RunTrafficIncidentsWarningClient.sh;exec bash\""


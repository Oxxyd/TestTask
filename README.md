# User-activity-tracking

There're 2 endpoints created in a project

First enpoint `/event/addNewEventRecord` is created to add a record of a new event. To perform this you need to send a json file of the following type:
 
 {
 
    "eventName": "Launches the application",
    "userAuthorizationStatus": true,
    "ipAddress" : "192.168.32.64"
    
}

  Second endpotin `/filter/getFilteringResult` created for receiving aggregated information. It is possible to obtain the number of events with
a specific name; the number of events from a specific user (by ip address); the number of events performed by an authorized or unauthorized user.
The following json file is sent to the address:

{

    "filterName": "by_event_name",
    "additionalParameter": "Start the application"
    
}

1. The name of what you want to filter by. The following options are possible: 
 - by_event_name
 - by_ip_address
 - by_user_authorization_status
2. Additional parameter:
 - For 1 item  - event name
 - For 2 item  - ip address
 - For 3 item  - true or false

Will be received json file with one field which will store a numeric value that will be equal to a certain number of those or other entries
in the database. Exmaple:

{

    "responseValue": 3
    
}




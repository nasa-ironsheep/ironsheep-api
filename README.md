# Space apps challenge 2016

## image.py
### Install
```zsh
pip install -r requirements.txt
```

### Run
```zsh
python image.py
```

### Request
| name  | type  | default  |  needed  |
|:-:|:-:|:-:|:-:|
| api_url  | string  | https://api.nasa.gov/planetary/earth/imagery  | no  |
| lon  | float  | 100.75  | yes  |
| lat  | float  | 1.5  | yes  |
| today | string  | YYYY-MM-DD(today)  | no  |
| cloud  | boolean  | True  |  no |
| api_key  | string  | "xxxxxxxxxxxxxxx"  |  no |
```zsh
curl http://127.0.0.1:5000/<lng>/<lat>
# Demo
curl http://127.0.0.1:5000/41.661414/-0.7776972
```

### Response
```json
{
  "grass": 0.84,
  "erro": 0.0214,
  "date": "2014-02-04T03:30:01"
}
```
```zsh
grass = float 0-1   # percent of grass
erro = float 0-1    # percent of error (cloud hiding the location)
date = string       # last inforeceived
```



## IRONSHEEP-SERVER
### Package
```zsh
cd $IRONSHEEP-SERVER_PATH
mvn package
```
The *war* file will generated on **$IRONSHEEP-SERVER_PATH/target**.

### Deploy
You 'll be able to deploy *war* file into an application server. Tested in WildFly-8.2.0 server.

### Call
```zsh
http://$HOST:$PORT/$APPLICATION_NAME/services/ruta
# Example
http://localhost:8080/IRONSHEEP-SERVER-0.1/services/ruta
```

### Request
POST request, adding `Content-Type: application/json` header.
```json
[
   {
      "lng": 39.86227,
      "lat": -4.034449
   },
   {
      "lng": 42.86227,
      "lat": -3.034449
   },
   {
      "lng": 43.86227,
      "lat": -2.034449
   }
]
```

### Response
Average response of several location points.
```json
{
  "greenZone":    {
     "grass": 0.84,
     "erro": 0.0214,
     "date": "2014-02-04T03:30:01"
  },
  "weather":    {
     "main": "Clouds",
     "temp": 30.15,
     "pressure": 1011,
     "humidity": 70,
     "windSpeed": 3.6
  }
}
```
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

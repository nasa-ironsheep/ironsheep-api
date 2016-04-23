# Space apps challenge 2016

## image.py
### Run
```zsh
python image.py <lon> <lat>
```

### Requirements python
```zsh
Pillow (3.2.0)
pip (8.1.1)
requests (2.9.1)
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

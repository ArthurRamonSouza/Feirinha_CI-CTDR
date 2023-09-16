import json

from flask import Flask, request, app, jsonify

api = Flask(__name__)
api.config['JSON_AS_ASCII'] = False

with open('C:/Users\davib\Documents/UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Webscrapping\matricula\matricula\spiders\cc.json',
          'r',encoding='utf-8') as arquivo_jsonCC:
    dados_jsonCC = json.load(arquivo_jsonCC, encoding='utf-8')

with open('C:/Users\davib\Documents/UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Webscrapping\matricula\matricula\spiders\ec.json','r',encoding='utf-8') as arquivo_jsonEC:
    dados_jsonEC = json.load(arquivo_jsonEC, encoding='utf-8')

with open('C:/Users\davib\Documents/UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Webscrapping\matricula\matricula\spiders\cdia.json','r',encoding='utf-8') as arquivo_jsonCDIA:
    dados_jsonCDIA = json.load(arquivo_jsonCDIA, encoding='utf-8')

with open('C:/Users\davib\Documents/UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Webscrapping\matricula\matricula\spiders\mc.json','r',encoding='utf-8') as arquivo_jsonMC:
    dados_jsonMC = json.load(arquivo_jsonMC, encoding='utf-8')


@api.route('/matriculaCC', methods=['GET'])
def obter_matriculaCC():
    return jsonify(dados_jsonCC)


@api.route('/matriculaCC/<string:matricula>', methods=['GET'])
def obter_matriculaCC_id(matricula):
    for dado in dados_jsonCC:
        if dado.get('matricula') == matricula:
            return jsonify(dado.get('nome'))


@api.route('/matriculaEC', methods=['GET'])
def obter_matriculaEC():
    return jsonify(dados_jsonEC)


@api.route('/matriculaEC/<string:matricula>', methods=['GET'])
def obter_matriculaEC_id(matricula):
    for dado in dados_jsonEC:
        if dado.get('matricula') == matricula:
            return jsonify(dado.get('nome'))


@api.route('/matriculaCDIA', methods=['GET'])
def obter_matriculaCDIA():
    return jsonify(dados_jsonCDIA)


@api.route('/matriculaCDIA/<string:matricula>', methods=['GET'])
def obter_matriculaCDIA_id(matricula):
    for dado in dados_jsonCDIA:
        if dado.get('matricula') == matricula:
            return jsonify(dado.get('nome'))


@api.route('/matriculaMC', methods=['GET'])
def obter_matriculaMC():
    return jsonify(dados_jsonMC)


@api.route('/matriculaMC/<string:matricula>', methods=['GET'])
def obter_matriculaMC_id(matricula):
    for dado in dados_jsonMC:
        if dado.get('matricula') == matricula:
            return jsonify(dado.get('nome'))


api.run(port=5000, host='localhost', debug=True)

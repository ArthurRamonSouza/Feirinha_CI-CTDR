import json

from flask import Flask, request, app, jsonify

api = Flask(__name__)
api.config['JSON_AS_ASCII'] = False

#EDITE AS VARIAVEIS DE SISTEMA AQUI
#pathCC = 'C:\\Users\davib\Documents\\UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Feirinha_CI-CTDR\matricula\matricula\spiders\json\cc.json'
#pathEC = 'C:\\Users\davib\Documents\\UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Feirinha_CI-CTDR\matricula\matricula\spiders\json\ec.json'
#pathMC = 'C:\\Users\davib\Documents\\UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Feirinha_CI-CTDR\matricula\matricula\spiders\json\mc.json'
#pathCDIA = 'C:\\Users\davib\Documents\\UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Feirinha_CI-CTDR\matricula\matricula\spiders\json\cdia.json'
#pathGS = 'C:\\Users\davib\Documents\\UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Feirinha_CI-CTDR\matricula\matricula\spiders\json\gs.json'
#pathTA = 'C:\\Users\davib\Documents\\UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Feirinha_CI-CTDR\matricula\matricula\spiders\json\\ta.json'
#pathTPS = 'C:\\Users\davib\Documents\\UFPB\SEMESTRE 4\ENGENHARIA DE SOFTWARE\Feirinha_CI-CTDR\matricula\matricula\spiders\json\\tps.json'

with open(pathCC,'r',encoding='utf-8') as arquivo_jsonCC:
    dados_jsonCC = json.load(arquivo_jsonCC)

with open(pathEC,'r',encoding='utf-8') as arquivo_jsonEC:
    dados_jsonEC = json.load(arquivo_jsonEC)

with open(pathCDIA,'r',encoding='utf-8') as arquivo_jsonCDIA:
    dados_jsonCDIA = json.load(arquivo_jsonCDIA)

with open(pathMC,'r',encoding='utf-8') as arquivo_jsonMC:
    dados_jsonMC = json.load(arquivo_jsonMC)

with open(pathGS,'r',encoding='utf-8') as arquivo_jsonGS:
    dados_jsonGS = json.load(arquivo_jsonGS)

with open(pathTA,'r',encoding='utf-8') as arquivo_jsonTA:
    dados_jsonTA = json.load(arquivo_jsonTA)

with open(pathTPS,'r',encoding='utf-8') as arquivo_jsonTPS:
    dados_jsonTPS = json.load(arquivo_jsonTPS)

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


@api.route('/matriculaGS', methods=['GET'])
def obter_matriculaGS():
    return jsonify(dados_jsonGS)


@api.route('/matriculaGS/<string:matricula>', methods=['GET'])
def obter_matriculaGS_id(matricula):
    for dado in dados_jsonGS:
        if dado.get('matricula') == matricula:
            return jsonify(dado.get('nome'))


@api.route('/matriculaTA', methods=['GET'])
def obter_matriculaTA():
    return jsonify(dados_jsonTA)


@api.route('/matriculaTA/<string:matricula>', methods=['GET'])
def obter_matriculaTA_id(matricula):
    for dado in dados_jsonTA:
        if dado.get('matricula') == matricula:
            return jsonify(dado.get('nome'))

@api.route('/matriculaTPS', methods=['GET'])
def obter_matriculaTPS():
    return jsonify(dados_jsonTPS)


@api.route('/matriculaTPS/<string:matricula>', methods=['GET'])
def obter_matriculaTPS_id(matricula):
    for dado in dados_jsonTPS:
        if dado.get('matricula') == matricula:
            return jsonify(dado.get('nome'))

api.run(port=5000, host='localhost', debug=True)

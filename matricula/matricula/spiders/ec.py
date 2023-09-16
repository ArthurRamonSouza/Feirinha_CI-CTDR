import os

import scrapy
from scrapy.crawler import CrawlerProcess


class EcSpider(scrapy.Spider):
    name = 'ec'
    start_urls = ['https://sigaa.ufpb.br/sigaa/public/curso/alunos.jsf?lc=pt_BR&id=1626865']

    def parse(self, response):
        for matriculas in response.css('.colMatricula'):
            yield {
                'nome': matriculas.css('.colMatricula+ td::text').get(),
                'matricula': matriculas.css('td.colMatricula::text').get()
            }

        pass

#Primeira vez que for gerar o json deixe comentado
#os.remove('json/cc.json')


process = CrawlerProcess(settings={
    'FEED_FORMAT': 'json',
    'FEED_URI': 'json/ec.json',
    'FEED_EXPORT_ENCODING': 'utf-8'
})

process.crawl(EcSpider)
process.start()

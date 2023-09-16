import os
import scrapy
from scrapy.crawler import CrawlerProcess


class GsSpider(scrapy.Spider):
    name = 'gs'
    start_urls = ['https://sigaa.ufpb.br/sigaa/public/curso/alunos.jsf?lc=pt_BR&id=1976359']

    def parse(self, response):
        for matriculas in response.css('.colMatricula'):
            yield{
                'nome': matriculas.css('.colMatricula+ td::text').get(),
                'matricula': matriculas.css('td.colMatricula::text').get()
            }

        pass

#Primeira vez que for gerar o json deixe comentado
#os.remove('json/cc.json')


process = CrawlerProcess(settings= {
    'FEED_FORMAT': 'json',
    'FEED_URI': 'json/gs.json',
    'FEED_EXPORT_ENCODING': 'utf-8'
})

process.crawl(GsSpider)
process.start()

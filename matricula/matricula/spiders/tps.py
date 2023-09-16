import os
import scrapy
from scrapy.crawler import CrawlerProcess


class TpsSpider(scrapy.Spider):
    name = 'tps'
    start_urls = ['https://sigaa.ufpb.br/sigaa/public/curso/alunos.jsf?lc=pt_BR&id=1626861']

    def parse(self, response):
        for matriculas in response.css('.colMatricula'):
            yield{
                'nome': matriculas.css('.colMatricula+ td::text').get(),
                'matricula': matriculas.css('td.colMatricula::text').get()
            }

        pass


os.remove('json/tps.json')


process = CrawlerProcess(settings={
    'FEED_FORMAT': 'json',
    'FEED_URI': 'json/tps.json',
    'FEED_EXPORT_ENCODING': 'utf-8'
})

process.crawl(TpsSpider)
process.start()

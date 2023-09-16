import os
import scrapy
from scrapy.crawler import CrawlerProcess


class CcSpider(scrapy.Spider):
    name = 'cc'
    start_urls = ['https://sigaa.ufpb.br/sigaa/public/curso/alunos.jsf?lc=pt_BR&id=1626669']

    def parse(self, response):
        for matriculas in response.css('.colMatricula'):
            yield{
                'nome': matriculas.css('.colMatricula+ td::text').get(),
                'matricula': matriculas.css('td.colMatricula::text').get()
            }

        pass


os.remove('json/cc.json')


process = CrawlerProcess(settings= {
    'FEED_FORMAT': 'json',
    'FEED_URI': 'json/cc.json',
    'FEED_EXPORT_ENCODING': 'utf-8'
})

process.crawl(CcSpider)
process.start()

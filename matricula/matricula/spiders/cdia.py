import os
import scrapy
from scrapy.crawler import CrawlerProcess


class CdiaSpider(scrapy.Spider):
    name = 'cdia'
    start_urls = ['https://sigaa.ufpb.br/sigaa/public/curso/alunos.jsf?lc=pt_BR&id=14289031']

    def parse(self, response):
        for matriculas in response.css('.colMatricula'):
            yield {
                'nome': matriculas.css('.colMatricula+ td::text').get(),
                'matricula': matriculas.css('td.colMatricula::text').get()
            }

        pass


os.remove("json/cdia.json")


process = CrawlerProcess(settings={
    'FEED_FORMAT': 'json',
    'FEED_URI': 'json/cdia.json',
    'FEED_EXPORT_ENCODING': 'utf-8'
})

process.crawl(CdiaSpider)
process.start()

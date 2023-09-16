import scrapy
from scrapy.crawler import CrawlerProcess
import os


class McSpider(scrapy.Spider):
    name = 'mc'
    start_urls = ['https://sigaa.ufpb.br/sigaa/public/curso/alunos.jsf?lc=pt_BR&id=1626769']

    def parse(self, response):
        for matriculas in response.css('.colMatricula'):
            yield {
                'nome': matriculas.css('.colMatricula+ td::text').get(),
                'matricula': matriculas.css('td.colMatricula::text').get()
            }

        pass


os.remove("mc.json")


process = CrawlerProcess(settings={
    'FEED_FORMAT': 'json',
    'FEED_URI': 'mc.json',
    'FEED_EXPORT_ENCODING': 'utf-8'
    
})

process.crawl(McSpider)
process.start()

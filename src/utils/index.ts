const fetchProducts = async (query: string) => {
    const response = await fetch(`https://api.mercadolibre.com/sites/MLB/search?q=${query}`);
    const results = await response.json().then(data=> data.results)
    return results
}

export default fetchProducts
export function AdvertiserProfile() {
    const advertiserImage = ""
    const advertiserName = "Nome do anunciante"
    const advertiserStars = 5
    const advertiserNumber = "(83) 99999-9999"
    const shoppingcartIcon = "src/assets/icons/shopping-cart.png"
    const exchangeIcon = "src/assets/icons/exchange.png"

    return (
        <div className="advertiser-profile">
            <img src={advertiserImage} alt="Advertiser image" />
            <p>{advertiserName}</p>
            <p>{advertiserStars}</p>
            <p>{advertiserNumber}</p>
            <div>
                <img src={shoppingcartIcon} />
                <button type="button">Comprar</button>
            </div>
            <div>
                <img src={exchangeIcon} />
                <button type="button">Sugerir troca</button>
            </div>
        </div>
    )
}
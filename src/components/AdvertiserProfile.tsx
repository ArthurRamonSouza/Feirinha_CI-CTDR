import "./components.css"

export function AdvertiserProfile() {
    const advertiserImage = "src/assets/icons/user.png"
    const advertiserName = "Nome do anunciante"
    const advertiserStars = 5
    const filledStar = "src/assets/icons/filled-star.png"
    const emptydStar = "src/assets/icons/empty-star.png"
    let star = emptydStar
    star = filledStar
    const advertiserNumber = "(83) 99999-9999"
    const shoppingcartIcon = "src/assets/icons/shopping-cart.png"
    const exchangeIcon = "src/assets/icons/exchange.png"

    return (
        <div className="advertiser-profile">
            <div className="overlap">
                <img className="advertiser-image" alt="Advertiser image" src={advertiserImage} />
                <div className="advertiser-name">{advertiserName}</div>
                <div className="stars">
                    <img className="star-1" alt="Star" src={star} />
                    <img className="star-2" alt="Star" src={star} />
                    <img className="star-3" alt="Star" src={star} />
                    <img className="star-4" alt="Star" src={star} />
                    <img className="star-5" alt="Star" src={star} />
                </div>
                <div className="advertiser-number">{advertiserNumber}</div>
                <div>
                    <div className="div">
                        <button className="buy-btn"><img src={shoppingcartIcon} alt="shoppingcartIcon" />Comprar</button>
                    </div>
                </div>
                <div>
                    <div className="overlap-group">
                        <button className="exchange-btn"><img src={exchangeIcon} alt="exchangeIcon" />Sugerir troca</button>
                    </div>
                </div>
            </div>
        </div>
    )
}
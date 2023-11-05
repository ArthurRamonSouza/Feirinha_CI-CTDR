import "./components.css"

interface AdvertiserProfileProps {
    onToggleExchange: () => void;
}

export const AdvertiserProfile: React.FC<AdvertiserProfileProps> = ({ onToggleExchange }) => {
    const advertiserImage: string = "src/assets/icons/user.png"
    const advertiserName: string = "Nome do anunciante"
    const advertiserStars: number = 5
    const filledStar: string = "src/assets/icons/filled-star.png"
    const emptydStar: string = "src/assets/icons/empty-star.png"
    let star: string = emptydStar
    star = filledStar
    const advertiserNumber: string = "(83) 99999-9999"
    const shoppingcartIcon: string = "src/assets/icons/shopping-cart.png"
    const exchangeIcon: string = "src/assets/icons/exchange.png"

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
                <button className="buy-btn"><img src={shoppingcartIcon} alt="shoppingcartIcon" />Comprar</button>
                <button className="exchange-btn" onClick={onToggleExchange}><img src={exchangeIcon} alt="exchangeIcon" />Sugerir troca</button>
            </div>
        </div>
    )
}
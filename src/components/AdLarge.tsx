export function AdLarge() {
    const adImage = ""
    const adTitle = "Título do produto"
    const adPrice = 0
    const adDescription = "Descrição do produto: Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

    return (
        <div className="ad-large">
            <p>{adTitle}</p>
            <img src={adImage} alt="Ad image" />
            <p>{adPrice}</p>
            <p>{adDescription}</p>
        </div>
    )
}
interface ExchangeSuggestionProps {
  onToggleExchange: () => void;
}

export const ExchangeSuggestion: React.FC<ExchangeSuggestionProps> = ({ onToggleExchange }) => {
  return (
    <div className="exchange-suggestion">
      <div className="top">
        <p>Sugerir troca</p>
        <button className="close-btn" onClick={onToggleExchange}><img src="src/assets/icons/close.png" alt="closeIcon" /></button>
      </div>
      <div className="bottom">
        <textarea className="exchange-description" placeholder="Descreva sobre o objeto de troca"></textarea>
        <button className="submit-btn" onClick={onToggleExchange}><img src="src/assets/icons/submit.png" alt="submitIcon" />Sugerir</button>
      </div>
    </div>
  )
}
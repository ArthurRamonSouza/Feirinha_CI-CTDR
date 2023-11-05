import { useState } from 'react';
import { AdLarge } from "../components/AdLarge"
import { AdvertiserProfile } from "../components/AdvertiserProfile"
import { ExchangeSuggestion } from "../components/ExchangeSuggestion"
import { HeaderSearchBar } from "../components/HeaderSearchBar"

const AdView = () => {
  const [showExchange, setShowExchange] = useState(false);

  const toggleExchange = () => {
    setShowExchange(!showExchange);
  };

  return (
    <div className="ad-view">
      <HeaderSearchBar />
      <div className="ad-body">
        <AdLarge />
        <AdvertiserProfile onToggleExchange={toggleExchange} />
      </div>
      {showExchange && <ExchangeSuggestion onToggleExchange={toggleExchange} />}
    </div>
  )
}

export default AdView
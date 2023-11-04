import { AdLarge } from "../../components/AdLarge"
import { AdvertiserProfile } from "../../components/AdvertiserProfile"
import { HeaderSearchBar } from "../../components/HeaderSearchBar"

const AdView = () => {
  return (
    <div className="ad-view">
      <HeaderSearchBar />
      <AdLarge />
      <AdvertiserProfile />
    </div>
  )
}

export default AdView
import { AdLarge } from "../../components/AdLarge"
import { AdvertiserProfile } from "../../components/AdvertiserProfile"
import { HeaderSearchBar } from "./../../components/HeaderSearchBar"

export function ViewAd() {
  return (
    <div>
      <HeaderSearchBar />
      <AdLarge />
      <AdvertiserProfile />
    </div>
  )
}
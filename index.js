/*
* @providesModule react-native-telephony-manager
*/
import { NativeModules, NativeAppEventEmitter, Platform } from 'react-native'

const RNTelephony = Platform.OS === 'ios' ? {} : NativeModules.Telephony

const EVENT_PHONE_STATE = 'phoneState'

const PHONE_STATE_LISTENER = 'Telephony-PhoneStateListener'

const telephony = RNTelephony

if (Platform.OS === 'android' && telephony) {
  telephony.addEventListener = (events, handler) => {
    RNTelephony && RNTelephony.startListener(events)
      NativeAppEventEmitter.addListener(
        PHONE_STATE_LISTENER,
        (result) => {
            handler(result);
        }
    );
  }

  telephony.removeEventListener = () => {
    RNTelephony && RNTelephony.stopListener()
      NativeAppEventEmitter.removeEventListener(
        PHONE_STATE_LISTENER,
        () => {}
    );
  }
}

export default telephony
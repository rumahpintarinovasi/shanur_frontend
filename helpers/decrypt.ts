import CryptoJS from 'crypto-js'

const config = useRuntimeConfig()
const privateKey : any = config.public.PRIVATE_KEY
const verifyToken = (encryptedData : any) => {
  const decipher = CryptoJS.AES.decrypt(encryptedData, privateKey);
  const originalText = decipher.toString(CryptoJS.enc.Utf8);

  return originalText;
};

export {
//   generateToken,
  verifyToken,
};

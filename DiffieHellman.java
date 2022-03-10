class DiffieHellman {
    public static void main(String args[]) {
        int p = 23; /* publicly known (prime number) */
        int g = 5; /* publicly known (primitive root) */
        int a = 4; /* only Alice knows this secret */
        int b = 3; /* onlb Bob knows this secret */

        double aliceSends = (Math.pow(g, a)) % p;
        double bobSends = (Math.pow(g, b)) % p;

        double aliceComputes = (Math.pow(bobSends, a)) % p;
        double bobComputes = (Math.pow(aliceSends, b)) % p;

        double sharedSecret = (Math.pow(g, (a * b))) % p;

        System.out.println(
                "simulation of Diffie-Hellman key exchange algorithm\n---------------------------------------------");
        System.out.println("Alice Sends : " + aliceSends);
        System.out.println("Bob Computes : " + bobComputes);
        System.out.println("Bob Sends : " + bobSends);
        System.out.println("Alice Computes : " + aliceComputes);
        System.out.println("Shared Secret : " + sharedSecret);

        /* shared secrets should match and equality is transitive */
        if ((aliceComputes == sharedSecret) && (aliceComputes == bobComputes))
            System.out.println("Success: Shared Secrets Matches! " + sharedSecret);
        else
            System.out.println("Error: Shared Secrets does not Match");
    }
}

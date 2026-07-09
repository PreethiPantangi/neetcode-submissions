class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> sett = new HashSet<>();
        for(String email : emails) {
            String formattedEmail = formatEmail(email);
            sett.add(formattedEmail);
        }
        return sett.size();
    }

    private String formatEmail(String email) {
        String[] chunks = email.split("@");
        String name = chunks[0];
        String domain = chunks[1];
        name = name.replaceAll("\\.", "");
        int plusIndex = name.indexOf('+');
        if(plusIndex != -1) {
            name = name.substring(0, plusIndex);
        }
        return name + domain;

    }
}